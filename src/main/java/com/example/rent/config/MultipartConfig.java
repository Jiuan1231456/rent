//package com.example.rent.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//@Configuration
//public class MultipartConfig {
//
//	@Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("utf-8"); // 設置默認編碼為 UTF-8
//        // resolver.setMaxUploadSize(5242880); // 如果需要限制上傳文件的大小，取消註解並設置合適的大小，這裡是5MB的限制
//        return resolver;
//    }
//	
//}
