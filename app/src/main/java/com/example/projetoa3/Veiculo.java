package com.example.projetoa3;

import androidx.annotation.NonNull;

public class Veiculo {

    public String id, marca;
    public double preco;

    @NonNull
    @Override
    public String toString() {
        return marca + " - R$ " + preco;
    }
}