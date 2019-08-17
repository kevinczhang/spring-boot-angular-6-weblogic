package com.upnxtblog.samples.props;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.upnxtblog.samples.props.model.AppCompiler;
import com.upnxtblog.samples.props.model.Menu;

@Component
@ConfigurationProperties("app")
public class AppProperties {
	private String error;
    private List<Menu> menus = new ArrayList<>();
    private AppCompiler compiler = new AppCompiler();
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public AppCompiler getCompiler() {
        return compiler;
    }

    public void setAppCompiler(AppCompiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "error='" + error + '\'' +
                ", menus=" + menus +
                ", compiler=" + compiler +
                '}';
    }
}
