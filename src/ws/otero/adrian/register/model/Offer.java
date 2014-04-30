package ws.otero.adrian.register.model;

public abstract class Offer
{
   protected Item product;
   protected String description;

   public Offer (
      Item product,
      String description )
   {
      this.product = product;
      this.description = description;
   }

   public Item getProduct ()
   {
      return product;
   }

   public String getDescription ()
   {
      return description;
   }

   public abstract double calculateDiscount ( Cart cart );

   public abstract String explainOffer ( Cart cart );
}
