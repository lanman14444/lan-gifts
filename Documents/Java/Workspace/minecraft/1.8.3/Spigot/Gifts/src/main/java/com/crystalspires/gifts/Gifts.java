package com.crystalspires.gifts;

import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Gifts
  extends JavaPlugin
{
  String prefix = "��6[Gifts] ";
  
  public void onEnable()
  {
    getLogger().info("Gifts v1.2 has been enabled");
  }
  
  public void onDisable()
  {
    getLogger().info("Gifts v1.2 has been disabled");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("gift"))
    {
      if (args.length < 2)
      {
        sender.sendMessage(this.prefix + "��4Please Specify what to gift and a player's name!");
        sender.sendMessage(this.prefix + "��4/gifts <Health/Hunger/Saturation/Item> <username>");
      }
      else
      {
        double sHealth;
        if (args[0].equalsIgnoreCase("health"))
        {
          if ((sender instanceof Player))
          {
            Player player = (Player)sender;
            UUID pID = null;
            for (Player pl : Bukkit.getOnlinePlayers()) {
              if (pl.getName().equalsIgnoreCase(args[1])) {
                pID = pl.getUniqueId();
              }
            }
            Player target = Bukkit.getServer().getPlayer(pID);
            if (target == null) {
              sender.sendMessage(this.prefix + "��4 Player is invalid or not online");
            } else if ((player.getGameMode() == GameMode.SURVIVAL) && (target.getGameMode() == GameMode.SURVIVAL))
            {
              if (target.getHealth() != target.getMaxHealth())
              {
                sHealth = player.getHealth();
                double tHealth = target.getHealth();
                sHealth -= 4.0D;
                tHealth += 4.0D;
                if (tHealth > target.getMaxHealth()) {
                  tHealth = target.getMaxHealth();
                }
                if (sHealth < 0.0D) {
                  sHealth = 0.0D;
                }
                player.setHealth(sHealth);
                target.setHealth(tHealth);
                sender.sendMessage(this.prefix + "��4You gave " + target.getName() + " two hearts.");
                target.sendMessage(this.prefix + "��4" + player.getName() + " gave you two hearts.");
              }
              else
              {
                player.sendMessage(this.prefix + "��4" + target.getName() + "'s health is full.");
              }
            }
            else {
              player.sendMessage(this.prefix + "��4Both players must be in survival");
            }
          }
          else
          {
            sender.sendMessage(this.prefix + "��4You MUST be a player");
          }
        }
        else
        {
          int sHunger;
          if (args[0].equalsIgnoreCase("Hunger"))
          {
            if ((sender instanceof Player))
            {
              Player player = (Player)sender;
              UUID pID = null;
              for (Player pl : Bukkit.getOnlinePlayers()) {
                if (pl.getName().equalsIgnoreCase(args[1])) {
                  pID = pl.getUniqueId();
                }
              }
              Player target = Bukkit.getServer().getPlayer(pID);
              if (target == null) {
                sender.sendMessage(this.prefix + "��4 Player is invalid or not online");
              } else if ((player.getGameMode() == GameMode.SURVIVAL) && (target.getGameMode() == GameMode.SURVIVAL))
              {
                if ((target.getFoodLevel() != 20) && (player.getFoodLevel() >= 4))
                {
                  sHunger = player.getFoodLevel();
                  int tHunger = target.getFoodLevel();
                  sHunger -= 4;
                  tHunger += 4;
                  if (tHunger > 20) {
                    tHunger = 20;
                  }
                  if (tHunger < 0) {
                    tHunger = 0;
                  }
                  player.setFoodLevel(sHunger);
                  target.setFoodLevel(tHunger);
                  sender.sendMessage(this.prefix + "��4You gave " + target.getName() + " two Hunger.");
                  target.sendMessage(this.prefix + "��4" + player.getName() + " gave you two Hunger.");
                }
                else
                {
                  player.sendMessage(this.prefix + "��4" + target.getName() + "'s hunger is full.");
                }
              }
              else {
                player.sendMessage(this.prefix + "��4Both players must be in survival");
              }
            }
            else
            {
              sender.sendMessage(this.prefix + "��4You MUST be a player");
            }
          }
          else
          {
            float sSaturation;
            if (args[0].equalsIgnoreCase("Saturation"))
            {
              if ((sender instanceof Player))
              {
                Player player = (Player)sender;
                UUID pID = null;
                for (Player pl : Bukkit.getOnlinePlayers()) {
                  if (pl.getName().equalsIgnoreCase(args[1])) {
                    pID = pl.getUniqueId();
                  }
                }
                Player target = Bukkit.getServer().getPlayer(pID);
                if (target == null) {
                  sender.sendMessage(this.prefix + "��4 Player is invalid or not online");
                } else if ((player.getGameMode() == GameMode.SURVIVAL) && (target.getGameMode() == GameMode.SURVIVAL))
                {
                  if (target.getSaturation() != 20.0F)
                  {
                    sSaturation = player.getSaturation();
                    float tSaturation = target.getSaturation();
                    sSaturation -= 4.0F;
                    tSaturation += 4.0F;
                    if (tSaturation > 20.0F) {
                      tSaturation = 20.0F;
                    }
                    if (tSaturation < 0.0F) {
                      tSaturation = 0.0F;
                    }
                    player.setSaturation(sSaturation);
                    target.setSaturation(tSaturation);
                    sender.sendMessage(this.prefix + "��4You gave " + target.getName() + " two Saturation.");
                    target.sendMessage(this.prefix + "��4" + player.getName() + " gave you two Saturation.");
                  }
                  else
                  {
                    player.sendMessage(this.prefix + "��4" + target.getName() + "'s Saturation is full.");
                  }
                }
                else {
                  player.sendMessage(this.prefix + "��4Both players must be in survival");
                }
              }
            }
            else if ((args[0].equalsIgnoreCase("Items")) || (args[0].equalsIgnoreCase("Item")))
            {
              if ((sender instanceof Player))
              {
                Player player = (Player)sender;
                UUID pID = null;
                for (Player pl : Bukkit.getOnlinePlayers()) {
                  if (pl.getName().equalsIgnoreCase(args[1])) {
                    pID = pl.getUniqueId();
                  }
                }
                Player target = Bukkit.getServer().getPlayer(pID);
                if (target == null) {
                  sender.sendMessage(this.prefix + "��4 Player is invalid or not online");
                } else if ((player.getGameMode() == GameMode.SURVIVAL) && (target.getGameMode() == GameMode.SURVIVAL))
                {
                  if ((target.getItemInHand().getType() == Material.AIR) || (player.getItemInHand() == null))
                  {
                    if ((player.getItemInHand().getType() != Material.AIR) || (player.getItemInHand() != null))
                    {
                      ItemStack gaveItem = player.getItemInHand();
                      player.setItemInHand(null);
                      target.setItemInHand(gaveItem);
                      player.sendMessage(this.prefix + "��2 You gave " + target.getName() + " " + gaveItem.getAmount() + " " + gaveItem.getType().toString().toLowerCase() + ".");
                      target.sendMessage(this.prefix + "��2" + player.getName() + " gave you " + gaveItem.getAmount() + " " + gaveItem.getType().toString().toLowerCase() + ".");
                    }
                    else
                    {
                      player.sendMessage(this.prefix + "��2 You can not gift nothing!");
                    }
                  }
                  else
                  {
                    player.sendMessage(this.prefix + "��4" + target.getName() + "'s hand is not empty");
                    target.sendMessage(this.prefix + "��4" + player.getName() + " tried to gift you an item but your hand was full.");
                  }
                }
                else {
                  player.sendMessage(this.prefix + "��4Both players must be in survival");
                }
              }
              else
              {
                sender.sendMessage(this.prefix + "��4You MUST be a player");
              }
            }
            else if ((!args[0].equalsIgnoreCase("Health")) || (!args[0].equalsIgnoreCase("Hunger")) || (!args[0].equalsIgnoreCase("Saturation")) || (!args[0].equalsIgnoreCase("Items")) || (!args[0].equalsIgnoreCase("Item")) || (!args[0].equalsIgnoreCase("Help"))) {
              sender.sendMessage(this.prefix + "��4" + args[0] + " is not a valid thing to do.");
            }
          }
        }
      }
      if (args.length == 1) {
        if (args[0].equalsIgnoreCase("help"))
        {
          sender.sendMessage("��4=��7-��6Gifts Help��7-��4=");
          sender.sendMessage("��4You give away what you are gifting");
          sender.sendMessage("��6/gift health <username> - Gift someone two hearts");
          sender.sendMessage("��6/gift hunger <username> - Gift someone two shanks of Hunger");
          sender.sendMessage("��6/gift Saturation <username> - Gift someone two saturation points");
          sender.sendMessage("��6/gift Item <username> - Gift someone the item in your hand.");
        }
      }
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("tprl"))
    {
      Random rand = new Random();
      Player player = (Player)sender;
      PotionEffect noDie = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 10, false, false);
      
      int x = rand.nextInt(20001) + 55536;
      int z = rand.nextInt(20001) + 55536;
      Location loc = new Location(player.getWorld(), x, 128.0D, z);
      player.teleport(loc);
      player.addPotionEffect(noDie);
    }
    return false;
  }
}
