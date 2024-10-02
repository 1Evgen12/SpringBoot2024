package ru.shilov.testsecurity2dbthemeleaf.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth-> auth.
                        requestMatchers("/h2-console/**").permitAll().
                        requestMatchers("/register/**").permitAll().
                        requestMatchers("/index").permitAll().
                        requestMatchers("/users").hasRole("ADMIN"))
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/users")
                        .permitAll()
                         ).logout(logout -> logout.logoutRequestMatcher(
                                 new AntPathRequestMatcher("/logout"))
                .permitAll());
        http.headers().frameOptions().disable();
        return http.build();*/

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/register/**").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/users").hasRole("ADMIN")
                .requestMatchers("/list").hasRole("ADMIN")
                .requestMatchers("/addStudentForm").hasRole("ADMIN")
                .requestMatchers("/saveStudent").hasRole("ADMIN")
                .requestMatchers("/showUpdateForm").hasRole("ADMIN")
                .requestMatchers("/deleteStudent").hasRole("ADMIN")
                .and()
                .formLogin(form -> form.
                        loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/users")
                        .permitAll())
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll());
        http.headers().frameOptions().disable();
        return http.build();

    }}
