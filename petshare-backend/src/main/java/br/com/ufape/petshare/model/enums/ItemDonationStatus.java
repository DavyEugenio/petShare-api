package br.com.ufape.petshare.model.enums;

public enum ItemDonationStatus {
    DISPONIVEL("Disponível"),
    EM_INTERESSE("Em interesse"),
    INDISPONIVEL("Indisponível"),
    CANCELADO("Cancelado"),
    RESERVADO("Reservado"),
    RECEBIDO("Recebido"),;

    private final String label;

    ItemDonationStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

}