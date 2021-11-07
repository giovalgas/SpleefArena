<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/giovalgas/SpleefArena">
    <img src="https://preview.redd.it/8gww4ffjw4h61.png?width=576&format=png&auto=webp&s=a14949a5d1b540a366af8de3cbd78e3407329d1c" alt="Logo" width="128" height="128">
  </a>

  <h3 align="center">Spleef Arena</h3>

  <p align="center">
    Adds a spleef arena into your server! <br />
    Supports 1.13-1.16.5
    <br />
    <br />
    <a href="https://www.youtube.com/watch?v=OONThSrhcRA">View Demo</a>
    ·
    <a href="https://github.com/giovalgas/SpleefArena/issues">Report Bug</a>
    ·
    <a href="https://github.com/giovalgas/SpleefArena/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Configuration](#configuration)
* [Usage](#usage)
* [Contributing](#contributing)
* [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project
<table>
  <tr>
    <td><img src="https://i.gyazo.com/ee47ba331ad846c6b07b0189bad4fbba.gif"></td>
    <td><img src="https://i.gyazo.com/659ca8ed462141ebb73f5fc750be8e32.gif"></td>
  </tr>
 </table>

Although this was made with the intent of adding it to my portfolio I fully intent to keep fixing bugs.

Features:
* Configurable.
* No lag.
* Supports most versions of mc.


### Built With
This project was built with:
* [Spigot](https://www.spigotmc.org/)
* [Java](https://java.com/pt-BR/)
* [XSeries](https://github.com/CryptoMorin/XSeries)
* [WorldGuard](https://www.curseforge.com/minecraft/mc-mods/worldedit)
* [WorldEdit](https://dev.bukkit.org/projects/worldguard)

### Support the dev

Enjoyed the plugin and want to support me monetarily? [buy me a coffe!](https://www.buymeacoffee.com/giovalgasdev)
Any donations are going to be **greatly appreciated!**
<!-- GETTING STARTED -->
## Getting Started

To get this plugin up and running you will only need to follow the following steps.

### Prerequisites

You will need these installed in your server before proceeding.

* [Spigot](https://www.spigotmc.org/)
* [WorldGuard](https://www.curseforge.com/minecraft/mc-mods/worldedit)
* [WorldEdit](https://dev.bukkit.org/projects/worldguard)


### Installation

1. Download the plugin at [https://github.com/giovalgas/SpleefArena/releases](https://github.com/giovalgas/SpleefArena/releases)
2. Put the downloaded jar into the plugins folder (yourServerFolder/plugins)

### Configuration

```yaml
#Config.yml - Spleef Arena  
  
console-prefix: "[SpleefArena] "  
  
arena:  
  reset-timer: 180 # Amount of seconds before a arena reset  
  reset-location: [723, 83, 1521] # Place where a player goes when he dies or leaves the arena [X,Y,Z]  
  death-height: 35 # Height value that kills the player  
  
items:  
  snowball-start-amount: 16 # Amount of snowballs you start with  
  snowball-break-amount: 1 # Amount of snowballs gained when you break a snow block
```

### Language

```yaml
#Language.yml - SpleefArena  
  
messages:  
  message-prefix: "&c[&6SpleefArena&c] "  
  
  help:  
  - "&8&m---------------------------------"  
  - "&e&lSpleefArena"  
  - "&7▪ &e/sa &7- Displays this list"  
  - "&7▪ &e/sa leave &7- Leaves the spleef arena"  
  - "&8&m---------------------------------"  
  
  no-permission: "&cYou don't have the permission needed to execute that command."  
  config-reloaded: "&eReloaded the config file!"  
  
  joined-spleef:  
  - "&eYou have joined the spleef arena!"  
  - "&eType &b/sa leave &eto leave"  
  left-spleef: "&eYou have left the spleef arena"  
  death-message: "&eYou have died in the spleef arena."  
  
  play-area-set: "&eSuccessfully set the arena area!"  
  layer-added: "&eSuccessfully added a new snow layer!"  
  
  selection-error: "&cYou need to make a selection first."
```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- CONTACT -->
## Contact

Giovani Valgas - [@giovalgas](https://twitter.com/giovalgas) - giovalgascom@gmail.com

Project Link: [https://github.com/giovalgas/SpleefArena](https://github.com/giovalgas/SpleefArena)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/giovalgas/SpleefArena.svg?style=flat-square
[contributors-url]: https://github.com/giovalgas/SpleefArena/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/giovalgas/SpleefArena.svg?style=flat-square
[forks-url]: https://github.com/giovalgas/SpleefArena/network/members
[stars-shield]: https://img.shields.io/github/stars/giovalgas/SpleefArena.svg?style=flat-square
[stars-url]: https://github.com/giovalgas/SpleefArena/stargazers
[issues-shield]: https://img.shields.io/github/issues/giovalgas/SpleefArena.svg?style=flat-square
[issues-url]: https://github.com/giovalgas/SpleefArena/issues

