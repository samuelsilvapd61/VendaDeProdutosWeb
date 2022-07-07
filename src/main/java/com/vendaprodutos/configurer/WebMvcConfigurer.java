package com.vendaprodutos.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

/**
 * Classe de configuração de Paginação
 *
 * @author Samuel Silva
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    /**
     * Esse método é só para selecionar como padrão o "page = 0" e "size = 10" caso esses parâmetros não sejam informados
     * Mas os parâmetros "size", "page" e "sort" já funcionam normalmente, sem a existência dessa classe e método
     * @param resolvers Resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //WebMvcConfigurer.super.addArgumentResolvers(resolvers);
        PageableHandlerMethodArgumentResolver pageHandler = new PageableHandlerMethodArgumentResolver();
        pageHandler.setFallbackPageable(PageRequest.of(0, 10));
        resolvers.add(pageHandler);
    }
}
