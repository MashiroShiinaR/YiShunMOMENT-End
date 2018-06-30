package com.YiShun;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Lanly on 2018/6/26 上午2:13
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("file:/usr/local/YiShunCache/");
    }


//    @Bean
//    public MiniInterceptor miniInterceptor() {
//        return new MiniInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
//                .addPathPatterns("/video/upload", "/video/uploadCover",
//                        "/video/userLike", "/video/userUnLike")
//                .addPathPatterns("/bgm/**")
//                .excludePathPatterns("/user/queryPublisher");
//
//        super.addInterceptors(registry);
//    }
}
