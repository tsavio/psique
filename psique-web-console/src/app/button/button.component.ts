import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
  selector: 'nb-button-showcase',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: '../app.component.html',
  styles: [`
    [nbButton] {
      margin-right: 0.75rem;
      margin-bottom: 1rem;
    }
  `],
})
export class ButtonShowcaseComponent {
}