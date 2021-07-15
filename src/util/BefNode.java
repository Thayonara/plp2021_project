package util;

import implementations.Id;

public class BefNode {

    Id plName, befNodeName;

    public BefNode(Id plName, Id befNodeName) {
        this.plName = plName;
        this.befNodeName = befNodeName;
    }

    public Id getPlName() {
        return plName;
    }

    public void setPlName(Id plName) {
        this.plName = plName;
    }

    public Id getBefNodeName() {
        return befNodeName;
    }

    public void setBefNodeName(Id befNodeName) {
        this.befNodeName = befNodeName;
    }
}

