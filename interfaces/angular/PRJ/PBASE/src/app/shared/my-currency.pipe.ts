import { Pipe, PipeTransform } from '@angular/core';
import { registerLocaleData, formatCurrency, getCurrencySymbol } from '@angular/common';
import localeES from '@angular/common/locales/es';

@Pipe({
  name: 'myCurrency'
})
export class MyCurrencyPipe implements PipeTransform {

  transform(value: number,
            currencyCode:string='EUR',
            display: |'code'|'symbol'|'symbol-narrow'|string|boolean='symbol',
            digitsInfo:string='2.2-2',
            locale:string='es'): string | null {
    
    registerLocaleData(localeES,'es');

    return formatCurrency(value, 
      locale, 
      getCurrencySymbol(currencyCode, 'wide'),
      digitsInfo);
  }

}
