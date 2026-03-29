https://ti323.onrender.com

# Substitua pela sua URL do Render
BASE="https://minha-api.onrender.com"

# Listar produtos
curl $BASE/api/produtos

# Criar produto
curl -X POST $BASE/api/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Notebook","preco":3500.00,"estoque":10}'

# Buscar por ID
curl $BASE/api/produtos/1


curl https://ti323.onrender.com/api/produtos

curl -X POST https://ti323.onrender.com/api/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Notebook","preco":3500.00,"estoque":10}'