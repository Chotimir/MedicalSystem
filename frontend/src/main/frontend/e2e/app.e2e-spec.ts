import { MedicalsystemPage } from './app.po';

describe('medicalsystem App', () => {
  let page: MedicalsystemPage;

  beforeEach(() => {
    page = new MedicalsystemPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
