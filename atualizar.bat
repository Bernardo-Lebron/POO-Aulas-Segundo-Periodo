@echo off
cd /d "C:\Users\berna\OneDrive\Área de Trabalho\2 Periodo\Lab. de POO"

echo 🔄 Puxando atualizações do GitHub...
git pull --rebase

echo ➕ Adicionando alterações...
git add .

echo 📝 Criando commit...
git commit -m "Atualização automática em %date% %time%"

echo 🚀 Enviando para o GitHub...
git push

echo ✅ Repositório atualizado com sucesso!
pause
