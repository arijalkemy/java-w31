&lt;!-- 🚀 Configurar Git para Separar Cuenta Personal y de Empresa --&gt;

Este proceso asegura que tu cuenta personal de GitHub funcione en repos específicos sin afectar la configuración de la empresa.

## 🔹 Paso 1: Crear y configurar la clave SSH personal  
Antes de empezar, asegurate de que ya tenés una clave SSH para tu cuenta personal o generá una nueva.

### 1.1 Generar una clave SSH nueva  
Abrí la terminal y ejecutá:  

```
ssh-keygen -t ed25519 -C "tu-email-personal@gmail.com"
```

Cuando te pida el nombre del archivo donde guardar la clave, escribí:  

```
~/.ssh/id_ed25519_personal
```

(No sobrescribas ninguna clave existente).  
Ingresá una contraseña si querés más seguridad (o dejalo en blanco).  

### 1.2 Agregar la clave SSH al agente SSH  
Ejecutá:  

```
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519_personal
```

Si al reiniciar la PC la clave no se carga automáticamente, agregá esto a `~/.ssh/config` (crealo si no existe):  

```
Host github.com-personal
  HostName github.com
  User git
  IdentityFile ~/.ssh/id_ed25519_personal
  IdentitiesOnly yes
```

### 1.3 Agregar la clave SSH a GitHub  
1️⃣ Copiá tu clave pública con:  

```
cat ~/.ssh/id_ed25519_personal.pub
```

2️⃣ Andá a **GitHub → Configuración → SSH and GPG keys**.  
3️⃣ Hacé clic en **New SSH Key**.  
4️⃣ Pegá la clave y guardala.  

Para probar la conexión, corré:  

```
ssh -T git@github.com-personal
```

Debería responder:  

```
Hi tbarenghi! You've successfully authenticated, but GitHub does not provide shell access.
```

## 🔹 Paso 2: Configurar un archivo `.gitconfig` para tu cuenta personal  
Git necesita saber cuándo usar tu usuario personal.  

### 2.1 Crear el archivo `~/.gitconfig-personal`  
En la terminal, ejecutá:  

```
nano ~/.gitconfig-personal
```

Pegá lo siguiente (reemplazando con tus datos):  

```
[user]
    name = Tu Nombre
    email = tu-email-personal@gmail.com

[url "git@github.com-personal:"]
    insteadOf = https://github.com/
    insteadOf = git@github.com:
```

Guardá el archivo:  
1️⃣ **CTRL + X** (para salir).  
2️⃣ **Y** (para confirmar).  
3️⃣ **Enter** (para guardar).  

## 🔹 Paso 3: Configurar cada repo personal para usar esta configuración  

### 3.1 Clonar o abrir un repositorio personal  
Si ya tenés un repo personal clonado, entrá a la carpeta:  

```
cd ~/ruta/del/repositorio
```

Si todavía no lo clonaste, hacelo con:  

```
git clone git@github.com-personal:tbarenghi/repo.git
cd repo
```

### 3.2 Configurar el repo para usar tu cuenta personal  
Dentro de la carpeta del repo, ejecutá:  

```
git config --local include.path ~/.gitconfig-personal
```

Para verificar:  

```
git config --list --local
```

Si todo está bien, deberías ver algo como:  

```
user.name=Tu Nombre
user.email=tu-email-personal@gmail.com
```

### 3.3 Cambiar la URL remota para usar SSH personal  
Primero, revisá qué remoto tiene el repo:  

```
git remote -v
```

Si ves algo como:  

```
origin  https://github.com/tbarenghi/repo.git (fetch)
origin  https://github.com/tbarenghi/repo.git (push)
```

Cambiá la URL a SSH personal:  

```
git remote set-url origin git@github.com-personal:tbarenghi/repo.git
```

Verificá que el cambio se hizo bien:  

```
git remote -v
```

Ahora debería mostrar:  

```
origin  git@github.com-personal:tbarenghi/repo.git (fetch)
origin  git@github.com-personal:tbarenghi/repo.git (push)
```

### 3.4 Probar si todo funciona  
1️⃣ Hacé un `git pull` para ver si podés descargar código sin errores:  

```
git pull origin main
```

2️⃣ Probá hacer un commit y push a tu repo personal:  

```
echo "prueba" >> test.txt
git add test.txt
git commit -m "Test de configuración personal"
git push origin main
```

Si todo está bien, el push debería hacerse sin problemas.  

## ✅ Resumen  
✔️ Generamos una clave SSH para tu cuenta personal.  
✔️ Configuramos Git para diferenciar entre cuentas.  
✔️ Modificamos los repos personales para que usen la configuración correcta.  
✔️ Probamos que el acceso a GitHub funcione correctamente.  

Con esto, tu cuenta corporativa sigue funcionando como siempre y tu cuenta personal solo se usa en repos personales. 🚀 