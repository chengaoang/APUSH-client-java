package org.apush;

import org.apush.msg.ShowDoc;

public class PUSH {
    public static String pushToShowDoc(ShowDoc p){
        return App.doPush(p.toJson());
    }
}
