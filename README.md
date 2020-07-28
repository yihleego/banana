# Banana

A FIGlet utility for Java.

## What is FIGlet
 
[FIGlet](https://en.wikipedia.org/wiki/FIGlet) is a computer program that generates text banners, in a variety of typefaces, composed of letters made up of conglomerations of smaller 
ASCII characters (see [ASCII art](https://en.wikipedia.org/wiki/ASCII_art)). The name derives from "Frank, Ian and Glenn's letters".

Being free software, FIGlet is commonly included as part of many Unix-like operating systems (Linux, BSD, etc.) distributions, but it has been ported to other platforms as well. The official FIGlet FTP site includes precompiled ports for the Acorn, Amiga, Apple II, Atari ST, BeOS, Macintosh, MS-DOS, NeXTSTEP, OS/2, and Windows platforms, as well as a reimplementation in Perl (Text::FIGlet). There are third-party reimplementations of FIGlet in Java (including one embedded in the JavE ASCII art editor), JavaScript, PHP and Python. FIGlet was featured as a Debian Package of the Day in 2007.

## Dependency

### Maven

```xml
<dependency>
    <groupId>io.leego</groupId>
    <artifactId>banana</artifactId>
    <version>1.3.1</version>
</dependency>
```

### Gradle

```xml
implementation 'io.leego:banana:1.3.1'
```

## Usage

### An example 

```java
BananaUtils.bananaify("Hello, Github!");
```
Output: 
```
  _   _      _ _           ____ _ _   _           _     _ 
 | | | | ___| | | ___     / ___(_) |_| |__  _   _| |__ | |
 | |_| |/ _ \ | |/ _ \   | |  _| | __| '_ \| | | | '_ \| |
 |  _  |  __/ | | (_) |  | |_| | | |_| | | | |_| | |_) |_|
 |_| |_|\___|_|_|\___( )  \____|_|\__|_| |_|\__,_|_.__/(_)
                     |/                                   
```


### Multiline

```java
String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\n"
        + "abcdefghijklmnopqrstuvwxyz\n"
        + "1234567890" + ". : , ; ' \" \\ ( ! ? ) + - * / =";
BananaUtils.bananaify(s);
```
Output: 
```
     _    ____   ____ ____  _____ _____ ____ _   _ ___    _ _  ___     __  __ _   _  ___  ____   ___  ____  ____ _____ _   ___     ____        ____  ____   _______
    / \  | __ ) / ___|  _ \| ____|  ___/ ___| | | |_ _|  | | |/ / |   |  \/  | \ | |/ _ \|  _ \ / _ \|  _ \/ ___|_   _| | | \ \   / /\ \      / /\ \/ /\ \ / /__  /
   / _ \ |  _ \| |   | | | |  _| | |_ | |  _| |_| || |_  | | ' /| |   | |\/| |  \| | | | | |_) | | | | |_) \___ \ | | | | | |\ \ / /  \ \ /\ / /  \  /  \ V /  / / 
  / ___ \| |_) | |___| |_| | |___|  _|| |_| |  _  || | |_| | . \| |___| |  | | |\  | |_| |  __/| |_| |  _ < ___) || | | |_| | \ V /    \ V  V /   /  \   | |  / /_ 
 /_/   \_\____/ \____|____/|_____|_|   \____|_| |_|___\___/|_|\_\_____|_|  |_|_| \_|\___/|_|    \__\_\_| \_\____/ |_|  \___/   \_/      \_/\_/   /_/\_\  |_| /____|
   __ _| |__   ___ __| | ___ / _| __ _| |__ (_)(_) | _| |_ __ ___  _ __   ___  _ __   __ _ _ __ ___| |_ _   ___   ____      ____  ___   _ ____                     
  / _` | '_ \ / __/ _` |/ _ \ |_ / _` | '_ \| || | |/ / | '_ ` _ \| '_ \ / _ \| '_ \ / _` | '__/ __| __| | | \ \ / /\ \ /\ / /\ \/ / | | |_  /                     
 | (_| | |_) | (_| (_| |  __/  _| (_| | | | | || |   <| | | | | | | | | | (_) | |_) | (_| | |  \__ \ |_| |_| |\ V /  \ V  V /  >  <| |_| |/ /                      
  \__,_|_.__/ \___\__,_|\___|_|  \__, |_| |_|_|/ |_|\_\_|_| |_| |_|_| |_|\___/| .__/ \__, |_|  |___/\__|\__,_| \_/    \_/\_/  /_/\_\\__, /___|                     
  _ ____  _____ _  _  ____   __ _|___/___  __|__/___                 _   _ _  |_|      _|_|_   ___  __                              |___/                          
 / |___ \|___ /| || || ___| / /|___  ( _ )/ _ \ / _ \    _       _  ( ) ( | ) \ \     / / | | |__ \ \ \     _            __/\__    / /  _____                      
 | | __) | |_ \| || ||___ \| '_ \ / // _ \ (_) | | | |  (_)     (_) |/   V V   \ \   | |  | |   / /  | |  _| |_   _____  \    /   / /  |_____|                     
 | |/ __/ ___) |__   _|__) | (_) / /| (_) \__, | |_| |   _   _   _              \ \  | |  |_|  |_|   | | |_   _| |_____| /_  _\  / /   |_____|                     
 |_|_____|____/   |_||____/ \___/_/  \___/  /_/ \___(_) (_) ( ) ( )              \_\ | |  (_)  (_)   | |   |_|             \/   /_/                                
                                                            |/  |/                    \_\           /_/                                                            
```


### More fonts

```java
List<String> fonts = BananaUtils.fonts();
for (String font : fonts) {
    BananaUtils.bananaify("Hello, Github!", font);
}
```
Examples:
```
[3D-ASCII]
 ___  ___  _______   ___       ___       ________                ________  ___  _________  ___  ___  ___  ___  ________  ___       
|\  \|\  \|\  ___ \ |\  \     |\  \     |\   __  \              |\   ____\|\  \|\___   ___\\  \|\  \|\  \|\  \|\   __  \|\  \      
\ \  \\\  \ \   __/|\ \  \    \ \  \    \ \  \|\  \             \ \  \___|\ \  \|___ \  \_\ \  \\\  \ \  \\\  \ \  \|\ /\ \  \     
 \ \   __  \ \  \_|/_\ \  \    \ \  \    \ \  \\\  \  ___        \ \  \  __\ \  \   \ \  \ \ \   __  \ \  \\\  \ \   __  \ \  \    
  \ \  \ \  \ \  \_|\ \ \  \____\ \  \____\ \  \\\  \|\  \        \ \  \|\  \ \  \   \ \  \ \ \  \ \  \ \  \\\  \ \  \|\  \ \__\   
   \ \__\ \__\ \_______\ \_______\ \_______\ \_______\ \  \        \ \_______\ \__\   \ \__\ \ \__\ \__\ \_______\ \_______\|__|   
    \|__|\|__|\|_______|\|_______|\|_______|\|_______|\/  /|        \|_______|\|__|    \|__|  \|__|\|__|\|_______|\|_______|   ___ 
                                                    |\___/ /                                                                  |\__\
                                                    \|___|/                                                                   \|__|
                                                                                                                                   
[ANSI_Shadow]
██╗  ██╗███████╗██╗     ██╗      ██████╗         ██████╗ ██╗████████╗██╗  ██╗██╗   ██╗██████╗ ██╗
██║  ██║██╔════╝██║     ██║     ██╔═══██╗       ██╔════╝ ██║╚══██╔══╝██║  ██║██║   ██║██╔══██╗██║
███████║█████╗  ██║     ██║     ██║   ██║       ██║  ███╗██║   ██║   ███████║██║   ██║██████╔╝██║
██╔══██║██╔══╝  ██║     ██║     ██║   ██║       ██║   ██║██║   ██║   ██╔══██║██║   ██║██╔══██╗╚═╝
██║  ██║███████╗███████╗███████╗╚██████╔╝▄█╗    ╚██████╔╝██║   ██║   ██║  ██║╚██████╔╝██████╔╝██╗
╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚═╝     ╚═════╝ ╚═╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝
                                                                                                 
[Small]
  _  _     _ _          ___ _ _   _        _    _ 
 | || |___| | |___     / __(_) |_| |_ _  _| |__| |
 | __ / -_) | / _ \_  | (_ | |  _| ' \ || | '_ \_|
 |_||_\___|_|_\___( )  \___|_|\__|_||_\_,_|_.__(_)
                  |/                              

[Standard] (Default font)
  _   _      _ _           ____ _ _   _           _     _ 
 | | | | ___| | | ___     / ___(_) |_| |__  _   _| |__ | |
 | |_| |/ _ \ | |/ _ \   | |  _| | __| '_ \| | | | '_ \| |
 |  _  |  __/ | | (_) |  | |_| | | |_| | | | |_| | |_) |_|
 |_| |_|\___|_|_|\___( )  \____|_|\__|_| |_|\__,_|_.__/(_)
                     |/            
```


### Fitting Layout

```java
BananaUtils.bananaify(
        "Hello, Github!",
        BananaUtils.LAYOUT_FULL,
        BananaUtils.LAYOUT_FULL
);
```
Output:
```
  _   _          _   _                  ____   _   _     _               _       _ 
 | | | |   ___  | | | |   ___          / ___| (_) | |_  | |__    _   _  | |__   | |
 | |_| |  / _ \ | | | |  / _ \        | |  _  | | | __| | '_ \  | | | | | '_ \  | |
 |  _  | |  __/ | | | | | (_) |  _    | |_| | | | | |_  | | | | | |_| | | |_) | |_|
 |_| |_|  \___| |_| |_|  \___/  ( )    \____| |_|  \__| |_| |_|  \__,_| |_.__/  (_)
                                |/                                                 
```


### ANSI escape code

```java
// Customize colours and styles
BananaUtils.bananansi(
        "Hello, Github!",
        Ansi.RED, Ansi.BG_YELLOW, Ansi.BOLD
);
```


## More

Click [here](https://github.com/yihleego/banana/blob/master/MORE.md) to see more fonts.

## Contact
> * Bugs: [Issues](https://github.com/yihleego/banana/issues)

## Links
> * [FIGlet Wiki](https://en.wikipedia.org/wiki/FIGlet)

## License
Banana is under the Apache 2.0 license. See the [LICENSE](https://github.com/yihleego/banana/blob/master/LICENSE.txt) file for 
details.

