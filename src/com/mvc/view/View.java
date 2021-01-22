package com.mvc.view;

import com.mvc.controller.Controller;
import com.mvc.model.ModelData;

public interface View {

    void refresh(ModelData modelData);
    void setController(Controller controller);

}