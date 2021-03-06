/*
 * Copyright (c) 2009 Piotr Piastucki
 * 
 * This file is part of Patchca captcha.patchca library.
 * 
 *  Patchca is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Patchca is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Patchca. If not, see <http://www.gnu.org/licenses/>.
 */
package cn.dreampie.captcha.text.render;

public class BestFitTextRender extends AbstractTextRender {

  public BestFitTextRender() {
    super();
  }

  public BestFitTextRender(int leftRightMargin, int topBottomMargin) {
    super(leftRightMargin, topBottomMargin);
  }

  public BestFitTextRender(int leftMargin, int rightMargin, int topMargin, int bottomMargin) {
    super(leftMargin, rightMargin, topMargin, bottomMargin);
  }

  protected void arrangeCharacters(int width, int height, TextString ts) {
    double widthRemaining = (width - ts.getWidth() - leftMargin - rightMargin) / ts.getCharacters().size();
    double x = leftMargin + widthRemaining / 2;
    height -= topMargin + bottomMargin;
    for (TextCharacter tc : ts.getCharacters()) {
      double y = topMargin + (height + tc.getAscent() * 0.7) / 2;
      tc.setX(x);
      tc.setY(y);
      x += tc.getWidth() + widthRemaining;
    }
  }

}
