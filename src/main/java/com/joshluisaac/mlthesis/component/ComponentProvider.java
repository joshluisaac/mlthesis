package com.joshluisaac.mlthesis.component;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.joshluisaac.mlthesis.utils.TextVectorizer;

@Component
public class ComponentProvider {
  
  public void textToVec(final String rootPath) throws IOException {
    new TextVectorizer().vectorize(rootPath);
  }
  

}
