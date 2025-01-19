package com.aluracursos.challenge.modelos;

import java.util.HashMap;

public class TasasDeCambio{
    private String base_code;
    private HashMap<String,Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }
    public String convertirMoneda(double valorMonedaBase, String codigoMonedaFinal){
        double tasaDeCambio = this.conversion_rates.get(codigoMonedaFinal);
        double valorMonedaFinal = valorMonedaBase * tasaDeCambio;
        return "El valor de %.2f [%s] corresponde al valor final de %.2f [%s] ".formatted(
                valorMonedaBase, this.base_code, valorMonedaFinal, codigoMonedaFinal);
    }
}