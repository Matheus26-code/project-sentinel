# 🛡️ Sentinel Ecosystem - Full Stack Java na AWS

O **Sentinel Ecosystem** é uma API robusta desenvolvida em Spring Boot, projetada para fornecer uma camada de monitoramento e gerenciamento de recursos. O projeto foi concebido para demonstrar a viabilidade de aplicações Java modernas em ambientes de nuvem containerizados.

## 🚀 Finalidade e Utilidade
Este ecossistema serve como base para monitoramento de ativos, oferecendo endpoints seguros para manipulação de dados em tempo real. É extremamente útil para empresas que buscam paridade entre ambientes de desenvolvimento e produção, garantindo que o código rode exatamente da mesma forma no computador do desenvolvedor e no servidor da AWS.

## 🛠️ Stack Tecnológica
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Banco de Dados:** H2 Database (In-Memory com Console remoto habilitado)
* **Containerização:** Docker & Docker Compose
* **Cloud:** AWS EC2 (Amazon Linux 2023)

* ## 🧪 Qualidade e Automação (QA)
Para garantir a integridade dos endpoints, desenvolvi uma suíte de testes automatizados utilizando:
* **Python 3.x**: Linguagem base para os scripts de teste.
* **Selenium/Pytest**: Validação de fluxos funcionais e integração com a API.

## 🧠 Desafios Enfrentados e Soluções

### 1. Conflito de Bytecode (Java 17 vs 11)
**Desafio:** Ocorreu o erro `UnsupportedClassVersionError` pois o ambiente de build tentava usar uma versão superior ao runtime do container.
**Solução:** Sincronização rigorosa da versão do JDK 17 (v61.0) em todas as camadas (Dockerfile, Maven e AWS).

### 2. Infraestrutura Imutável na AWS
**Desafio:** A distribuição Amazon Linux 2023 exigia plugins específicos para orquestração moderna.
**Solução:** Realizei o provisionamento manual do **Docker Buildx v0.17.0** e do link simbólico para o **Docker Compose**, garantindo builds rápidos e resilientes na nuvem.

### 3. Build in-Cloud e Codificação
**Desafio:** Arquivos de configuração gerados no Windows causavam falhas de leitura no Linux (`MalformedInputException`).
**Solução:** Implementação de um pipeline de **Build in-Cloud** com Maven, sanitizando recursos via terminal SSH para garantir integridade total dos artefatos.

### 4. Segurança de Acesso Remoto
**Desafio:** O banco de dados H2 bloqueava conexões externas por padrão.
**Solução:** Configuração de diretivas `web-allow-others` e ajuste de Security Groups na AWS para permitir auditoria remota segura.

---
## 📦 Como Executar
1. Clone o repositório: `git clone https://github.com/seu-usuario/project-sentinel.git`
2. Na raiz, execute: `docker compose up -d --build`
3. Acesse a API em: `http://seu-ip:8080`