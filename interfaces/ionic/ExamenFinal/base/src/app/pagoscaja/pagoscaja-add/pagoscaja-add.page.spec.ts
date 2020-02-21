import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PagoscajaAddPage } from './pagoscaja-add.page';

describe('PagoscajaAddPage', () => {
  let component: PagoscajaAddPage;
  let fixture: ComponentFixture<PagoscajaAddPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagoscajaAddPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PagoscajaAddPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
