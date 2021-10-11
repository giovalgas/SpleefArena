<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/giovalgas/TemplatePlugin">
    <img src="https://static.spigotmc.org/img/spigot-og.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Spigot Template</h3>

  <p align="center">
     Classes that help with plugin development!
    <br />
    <br />
    <a href="https://github.com/giovalgas/Mines/issues">Report Bug</a>
    ·
    <a href="https://github.com/giovalgas/Mines/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Contributing](#contributing)
* [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project
<table>
  <tr>
    <td><img width=400 height=300 src="https://i.gyazo.com/98075c76bae3f22dbc410835c2fb9474.gif"></td>
    <td><img width=400 height=300 src="https://i.gyazo.com/e9d14a6dc4c85f318a1f9cb8ecbb8b97.gif"></td>
  </tr>
 </table>

Template made to facilitate the making of spigot plugins!

Features:
* Better command handling 
* Managing Config/Language 
* Easier handling of GUIs
### Built With
This project was built with:
* [Spigot](https://www.spigotmc.org/)
* [Java](https://java.com/pt-BR/)
* [NBTItem API](https://www.spigotmc.org/resources/nbt-api.7939/)
* [XSeries](https://github.com/CryptoMorin/XSeries/)


<!-- GETTING STARTED -->
## Getting Started

### GUI Handling

#### Non paginated GUI
~~~java
public class ExampleMenu extends BaseGUI {  
  
  public ExampleMenu(Player player) {  
    super(player);  
  }  
  
  @Override  
  public void handleClick(InventoryClickEvent event) {  
    NBTItem nbtItem = new NBTItem(event.getCurrentItem());  
  
    if(nbtItem.hasKey(GUIButton.IDENTIFIER_KEY)) {  
      switch(nbtItem.getString(GUIButton.IDENTIFIER_KEY)) {  
        case "TEST":  
          player.sendMessage("BTN = TEST");  
          break;  
      }  
    }  
    else player.sendMessage("BTN = NULL");  
  
  }  
  
  @Override  
  public void setupInventoryItems() {  
    inventory.setItem(0, new GUIButton(new ItemStack(XMaterial.COAL_BLOCK.parseMaterial()), "TEST").getItemStack());  
    fillInventory(0, getSize());  
  }  
  
  @Override  
  public @NotNull String getName() {  
    return "Example menu";  
  }  
  
  @Override  
  public int getSize() {  
    return 9;  
  }  
}
~~~

#### Paginated GUI

~~~java
public class ExamplePaginatedMenu extends PaginatedGUI {  
  
  public ExamplePaginatedMenu(Player player) {  
    super(player);  
  }  
  
  @Override  
  public void handleClick(InventoryClickEvent event) {  
  
    NBTItem nbtItem = new NBTItem(event.getCurrentItem());  
  
    if(nbtItem.hasKey(GUIButton.IDENTIFIER_KEY)) {  
      switch(nbtItem.getString(GUIButton.IDENTIFIER_KEY)) {  
        case "NEXT_PAGE":  
          setPage(page + 1);  
          break;  
        case "PREVIOUS_PAGE":  
          setPage(page - 1);  
          break;  
      }  
    }  
  }  
  
  @Override  
  public void setupInventoryItems() {  
    inventory.setItem(47, new GUIButton(new ItemStack(XMaterial.STONE_BUTTON.parseMaterial()), "PREVIOUS_PAGE").getItemStack());  
    inventory.setItem(51, new GUIButton(new ItemStack(XMaterial.STONE_BUTTON.parseMaterial()), "NEXT_PAGE").getItemStack());  
    fillInventory(45, getSize());  
  }  
  
  @Override  
  public @NotNull String getName() {  
    return "Example Paginated Menu";  
  }  
  
  @Override  
  public int getSize() {  
    return 54;  
  }  
  
  @Override  
  public @NotNull ArrayList<ItemStack> getPageItems() {  
  
    ArrayList<ItemStack> items = new ArrayList<>();  
    for(int i = 0; i < 128; i++) {  
      if(i % 2 == 0) {  
        items.add(new ItemStack(Material.DIAMOND));  
      }else{  
        items.add(new ItemStack(Material.EMERALD));  
      }  
    }  
    return items;  
  
  }  
  
  @Override  
  public int getPageSize() {  
    return 45;  
  }
~~~

### Command Handling

~~~java
public ExampleCommand(TemplatePlugin plugin) {  
  super(plugin);  
  
  //add all subcommands here
  subCommands.put("TEST", new ExampleSubCommand());  
}  
  
  
@Override  
public void executeStockSubCommand(CommandSender sender) { 
  //stock command is executed if there are no arguments  
  plugin.getLog().info("executing stock command!");  
}  
  
@Override  
public @NotNull String getPermission() {  
  //permission to execute the command (includes all subcommands)
  return Permission.TPCOMMAND;  
}  
  
@Override  
public @NotNull String getName() {  
  //command name (same one as in plugin.yml)
  return "excommand";  
}  
  
  
@Override  
public @NotNull List<String> getAliases() { 
  //aliases (same ones as in plugin.yml)
  return Arrays.asList(new String[]{"excmd"}.clone()); 
}  
  
@Override  
public boolean isPlayerOnly() {  
  //is the command meant to be executed only by players
  return false;  
}
~~~
#### Subcommand example

~~~java
public class ExampleSubCommand implements SubCommand {  
  @Override  
  public void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin) { 
	//subcommand logic 
    sender.sendMessage(plugin.getLanguageManager().getHelloWorld());  
    Player player = (Player) sender; 
    if(sender instanceof Player){  
      plugin.getLanguageManager().getClickSound().playSound((Player) sender);  
    }  
  }  
  
  @Override  
  public @NotNull String getPermission() {  
	//permission needed to execute this subcommand
    return Permission.ADMIN;  
  }  
  
  @Override  
  public @Nullable String[] getArguments() {  
    //subcommand arguments (used to help with tab completion)
    return null;  
  }  
}
~~~

#### Main class
In order to register the command you'll need to add this into your main class.
~~~java
private void loadCommands() {  
  loadCommand(new ExampleCommand(this));  
}
~~~


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

Project Link: [https://github.com/giovalgas/TemplatePlugin](https://github.com/giovalgas/TemplatePlugin)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/giovalgas/TemplatePlugin.svg?style=flat-square
[contributors-url]: https://github.com/giovalgas/TemplatePlugin/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/giovalgas/TemplatePlugin.svg?style=flat-square
[forks-url]: https://github.com/giovalgas/TemplatePlugin/network/members
[stars-shield]: https://img.shields.io/github/stars/giovalgas/TemplatePlugin.svg?style=flat-square
[stars-url]: https://github.com/giovalgas/TemplatePlugin/stargazers
[issues-shield]: https://img.shields.io/github/issues/giovalgas/TemplatePlugin.svg?style=flat-square
[issues-url]: https://github.com/giovalgas/TemplatePlugin/issues
