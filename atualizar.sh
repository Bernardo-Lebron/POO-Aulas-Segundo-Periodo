#!/bin/bash
# Script automático para atualizar o repositório no GitHub

# Ir para a pasta onde o script está
cd "$(dirname "$0")"

# Mensagem de commit com data/hora
msg="Atualização automática em $(date '+%d/%m/%Y %H:%M:%S')"

echo "🔄 Puxando atualizações do GitHub..."
git pull --rebase

echo "➕ Adicionando alterações..."
git add .

echo "📝 Criando commit..."
git commit -m "$msg"

echo "🚀 Enviando para o GitHub..."
git push

echo "✅ Repositório atualizado com sucesso!"
