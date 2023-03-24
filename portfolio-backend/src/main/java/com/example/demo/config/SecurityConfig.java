package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.filter.JsonAuthenticationFilter;
import com.example.demo.filter.LoginFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // corsの設定をする
    http.cors().configurationSource(this.corsConfigurationSource());

    // 認証
    http.authorizeHttpRequests().antMatchers("/").permitAll().antMatchers("/api/login").permitAll()
        .antMatchers("/api/user/register").permitAll().antMatchers("/api/**").authenticated();

    // 独自フィルターの利用
    // デフォルトのAuthenticationManagerを利用し、パスワードハッシュ化用エンコーダーを渡す
    http.addFilter(new JsonAuthenticationFilter(authenticationManager()));

    // 適切なtokenか判断するフィルター
    http.addFilterAfter(new LoginFilter(), JsonAuthenticationFilter.class);

    // csrfを無効にしておく
    // またCookieを利用してcsrf対策を行う
    http.csrf().ignoringAntMatchers("/api/**");
  }

  private CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
    corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
    // トークン用ヘッダー項目
    corsConfiguration.addExposedHeader("X-AUTH-TOKEN");

    // リクエストを許可するオリジンリスト
    corsConfiguration.addAllowedOrigin("http://localhost:3000");
    corsConfiguration.addAllowedOrigin("http://35.79.86.100");
    // 追加
    corsConfiguration.addAllowedOrigin("http://10.246.160.32:3000");
    corsConfiguration.addAllowedOrigin("http://10.246.160.5");
    // ドメイン対応
    corsConfiguration.addAllowedOrigin("http://ysapp2486.com/");
    // https化対応
    corsConfiguration.addAllowedOrigin("https://ysapp2486.com/");
    corsConfiguration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
    corsSource.registerCorsConfiguration("/**", corsConfiguration);
    return corsSource;
  }

  // パスワードハッシュ化用エンコーダー
  @Bean
  BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
