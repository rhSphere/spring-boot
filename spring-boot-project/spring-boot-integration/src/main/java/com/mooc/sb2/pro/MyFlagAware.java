package com.mooc.sb2.pro;

import org.springframework.beans.factory.Aware;

public interface MyFlagAware extends Aware {

    void setFlag(Flag flag);

}
