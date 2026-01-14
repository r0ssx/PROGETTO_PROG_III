package Shared.GsonAdapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.util.List;

public class CartPacket {
    public List<String> codici_prodotto;
    public String email;
    public String metodo_pagamento;
    public String quantità_acquistata;
}
