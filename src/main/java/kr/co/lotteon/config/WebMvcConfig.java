package kr.co.lotteon.config;

import kr.co.lotteon.intercepter.Appinfointercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //private String connectPath = "/imagePath/**";

    //
    //private String resourcePath = "file:///Users/Java/Desktop/WorkSpace/lotteon-team1/lotteon/uploads";
    // 배포
    // private String resourcePath = "file:///home/farmStory/prodImg/";


    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${file.upload.path}")
    private String resourcePath;

    /*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/admin/**").addResourceLocations("classpath:/admin/");
        registry.addResourceHandler("/uploads/**").addResourceLocations(resourceLoader.getResource("file:" + resourcePath));

    }


    // 버전 정보 띄우기
    @Autowired
    private AppInfo appInfo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Appinfointercepter(appInfo));

    }
}