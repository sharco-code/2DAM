import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
    name: 'filter'
})
export class FilterPipe  implements PipeTransform {

      private searchedItems: Array<any> = [];
      private key: string; private prop: string;
      private childrenPropName: string;
    
      transform(value: any, key?: any, prop?: any, childrenProp?: any): any {
        if(key != undefined) {
          this.searchedItems = [];
          this.key = key.toLowerCase();
          this.prop = prop;
          this.childrenPropName = childrenProp;
          let searchResult = this.searchRecursive(value);
          return searchResult;
        }
        return value;
      }
    
      searchRecursive(value) {
        let condicio=false;  
        for(var i = 0; i < value.length; i++) {
                  
       
          let proptipo=typeof(value[i][this.prop]);

          //Avalua la igualtat
      
          if  ( proptipo =="string") {
               let lowerCaseName = value[i][this.prop].toLowerCase();
               condicio = lowerCaseName.includes(this.key) || value[i][this.prop].includes(this.key);
          } else if  (proptipo =="number") {
               condicio = value[i][this.prop] == this.key;              
          } else{
               condicio =value[i][this.prop] ==this.key;
          }
          if(condicio  ) { // Si son iguals
            this.searchedItems.push(value[i]); // Afegir l'element al resultat
          } else if(value[i][this.childrenPropName]) {
            if(value[i][this.childrenPropName].length > 0) {
              this.searchRecursive(value[i][this.childrenPropName]);
            }
          }
        }
        return this.searchedItems;
      }
    }




// Mejora: fer un servicio !!!
// 
