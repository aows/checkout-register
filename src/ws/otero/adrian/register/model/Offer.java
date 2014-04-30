package ws.otero.adrian.register.model;

/**
 * Represents an Offer. An offer will always have a description and it'll be applied to a specific product.
 *
 * @author Adrian Otero
 */
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

   /**
    * Calculates the discount for the given shopping cart
    *
    * @param cart current shopping cart with all the items
    * @return discount to apply
    */
   public abstract double calculateDiscount ( Cart cart );

}
