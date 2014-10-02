/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd;

import io.konik.builder.Builder;
import io.konik.zugferd.entity.Context;
import io.konik.zugferd.entity.Header;
import io.konik.zugferd.entity.trade.Trade;
import io.konik.zugferd.profile.ConformanceLevel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * = The Root of the ZUGFeRD Invoice Model.
 */
@XmlRootElement(name = "CrossIndustryDocument")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "context", "header", "trade" })
@GeneratePojoBuilder(withBuilderInterface = Builder.class, withBuilderProperties = true)
public class Invoice {

   @NotNull
   @Valid
   @XmlElement(name = "SpecifiedExchangedDocumentContext", required = true)
   private Context context;

   @NotNull
   @Valid
   @XmlElement(name = "HeaderExchangedDocument", required = true)
   private Header header;

   @NotNull
   @Valid
   @XmlElement(name = "SpecifiedSupplyChainTradeTransaction", required = true)
   private Trade trade;

   Invoice() {
   }

   /**
    * Instantiates a new invoice with a profile.
    * 
    * @param profile the profile
    */
   public Invoice(ConformanceLevel profile) {
      this.context = new Context(profile);
   }

   /**
    * Gets the exchanged document context.
    * 
    * @return the exchanged document context
    */
   public Context getContext() {
      return context;
   }

   /**
    * Sets the exchanged document context.
    * 
    * @param context the new exchanged document context
    */
   public void setContext(Context context) {
      this.context = context;
      
   }

   /**
    * Gets the document header
    * 
    * @return the exchange document header
    */
   public Header getHeader() {
      return header;
   }

   /**
    * Sets the header.
    * 
    * @param header the new exchange document header
    */
   public void setHeader(Header header) {
      this.header = header;
      
   }

   /**
    * Gets the trade transaction.
    *
    * @return the trade
    */
   public Trade getTrade() {
      return trade;
   }

   /**
    * Sets the trade transaction.
    *
    * @param trade the new trade
    */
   public void setTrade(Trade trade) {
      this.trade = trade;
      
   }
}
