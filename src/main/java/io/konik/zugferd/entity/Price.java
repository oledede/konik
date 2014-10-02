/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.entity;

import io.konik.jaxb.adapter.AmountHighRoundingAdapter;
import io.konik.validator.annotation.Comfort;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Price
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradePriceType", propOrder = { "chargeAmount", "basis", "allowanceCharges" })
public class Price {

   @Valid
   @NotNull(groups = Comfort.class)
   @XmlElement(name = "ChargeAmount")
   @XmlJavaTypeAdapter(value = AmountHighRoundingAdapter.class)
   private Amount chargeAmount;

   @Valid
   @XmlElement(name = "BasisQuantity")
   private Quantity basis;

   @XmlElement(name = "AppliedTradeAllowanceCharge")
   protected List<AllowanceCharge> allowanceCharges;

   Price() {
   }

   /**
    * Instantiates a new price.
    *
    * @param chargeAmount the charge amount
    */
   public Price(Amount chargeAmount) {
      super();
      this.chargeAmount = chargeAmount;
   }

   /**
    * Gets the charge amount.
    * 
    * @return the charge amount
    */
   public Amount getChargeAmount() {
      return chargeAmount;
   }

   /**
    * Sets the charge amount.
    *
    * @param chargeAmount the new charge amount
    */
   public void setChargeAmount(Amount chargeAmount) {
      this.chargeAmount = chargeAmount;
      
   }

   /**
    * Gets the basis quantity.
    * 
    * @return the basis quantity
    */
   public Quantity getBasis() {
      return basis;
   }

   /**
    * Sets the basis quantity.
    *
    * @param quantity the new basis quantity
    */
   public void setBasis(Quantity quantity) {
      this.basis = quantity;
      
   }

}
