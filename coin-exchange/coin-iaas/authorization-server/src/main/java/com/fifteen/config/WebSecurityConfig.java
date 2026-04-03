package com.fifteen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        User user = new User("admin", "123456", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//        inMemoryUserDetailsManager.createUser(user);
//        return inMemoryUserDetailsManager;
//    }

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("e10adc3949ba59abbe56e057f20f883e");
        String encode = bCryptPasswordEncoder.encode("123456");

        String encode1 = bCryptPasswordEncoder.encode("e10adc3949ba59abbe56e057f20f883e");
        System.out.println("encode1:"+encode1);

        boolean matches1 = bCryptPasswordEncoder.matches("e10adc3949ba59abbe56e057f20f883e", "$2a$10$zICBxCe29pBXJY692R734OwWYuzU9yloLjI2326SPHrw0CEIHCKHK");

        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$5FRwll0XDNPyIRrYzi1FpO9IoUEPTh/gbc6n3h3lNPDFPzZoCxisq");
        System.out.println(matches);
        System.out.println(encode);
    }
}
