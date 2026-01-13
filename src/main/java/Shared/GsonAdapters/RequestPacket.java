package Shared.GsonAdapters;

import Shared.Requests.Request;

public class RequestPacket extends Packet {
    public Request request;

    public RequestPacket(){}

    public RequestPacket(Request request) {
        this.request = request;
    }
}
