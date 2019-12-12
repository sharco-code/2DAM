import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'mySort'
})
export class MySortPipe  implements PipeTransform {
    transform(array: Array<string>, args: string): Array<string> {
        if(!array)
        {
            return [];
        }
        if (array.length > 0) {
            array.sort((a: any, b: any) => {
                if (a[args] < b[args]) {
                    return -1;
                } else if (a[args] > b[args]) {
                    return 1;
                } else {
                    return 0;
                }
            });
            return array;
        }
    }
}
