public class Endereco {
        private String cep;
        private String rua;
        private String bairro;
        private String estado;
        private String uf;
        private String cidade;
        private String ddd;

        public Endereco(EnderecoApiCep meuEndereco) {
            this.cep = meuEndereco.cep();
            this.rua = meuEndereco.logradouro();
            this.bairro = meuEndereco.bairro();
            this.estado = meuEndereco.estado();
            this.uf = meuEndereco.uf();
            this.cidade = meuEndereco.localidade();
            this.ddd = meuEndereco.ddd();
        }


        @Override
        public String toString() {
            return "(cep = " + cep +
                    ", rua = " + rua +
                    ", bairro = " + bairro +
                    ", cidade = " + cidade +
                    ", estado = " + estado +
                    ", uf = " + uf +
                    ", ddd = " + ddd + ")";

        }
}