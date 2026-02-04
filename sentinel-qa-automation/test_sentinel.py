import requests

def testar_cadastro_e_listagem():
    url = "http://localhost:8080/api/produtos"
    
    # 1. Testando o POST (Cadastro)
    novo_produto = {"nome": "Monitor Gamer", "preco": 1200.50}
    # Enviamos o dicionário como JSON
    resposta_post = requests.post(url, json=novo_produto) 
    
    assert resposta_post.status_code == 200
    print(f"[QA] Produto cadastrado: {resposta_post.json()}")

    # 2. Testando o GET (Listagem)
    resposta_get = requests.get(url)
    assert len(resposta_get.json()) > 0
    print(f"[QA] Listagem confirmada! Itens no banco: {len(resposta_get.json())}")

if __name__ == "__main__":
    testar_cadastro_e_listagem()