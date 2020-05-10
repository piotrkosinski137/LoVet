import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'enumDigitsFilter',
    pure: false
})
export class EnumFilterPipe implements PipeTransform {
    transform(enums: any[]): any {
        return enums.filter(enumOption => !isNaN(enumOption.key) && enumOption.key !== 'values');
    }
}
