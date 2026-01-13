package Shared.GsonAdapters;

import Shared.Requests.Request;

public class RequestPacket {
    public Request request;

    public RequestPacket(){}

    public RequestPacket(Request request) {
        this.request = request;
    }
}
