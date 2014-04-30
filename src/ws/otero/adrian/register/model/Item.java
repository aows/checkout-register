package ws.otero.adrian.register.model;

public class Item
{
   private String code;
   private String name;
   private double price;

   public Item (
      String code,
      String name,
      double price )
   {
      this.code = code;
      this.name = name;
      this.price = price;
   }

   public String getCode ()
   {
      return code;
   }

   public double getPrice ()
   {
      return price;
   }

   public String getName ()
   {
      return name;
   }

}
