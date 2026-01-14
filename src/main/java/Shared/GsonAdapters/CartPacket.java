package Shared.GsonAdapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.util.List;

public class CartPacket {
    public List<String> codici_prodotto;
    public List<String> quantità_acquistata;
    public String email;
    public String metodo_pagamento;

}
