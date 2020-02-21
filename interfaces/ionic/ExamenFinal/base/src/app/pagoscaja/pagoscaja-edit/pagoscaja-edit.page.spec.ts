import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PagoscajaEditPage } from './pagoscaja-edit.page';

describe('PagoscajaEditPage', () => {
  let component: PagoscajaEditPage;
  let fixture: ComponentFixture<PagoscajaEditPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagoscajaEditPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PagoscajaEditPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
