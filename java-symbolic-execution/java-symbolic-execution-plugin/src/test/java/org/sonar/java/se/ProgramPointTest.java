/*
 * SonarQube Java
 * Copyright (C) 2012-2024 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.java.se;

import org.junit.jupiter.api.Test;
import org.sonar.java.cfg.CFG;
import org.sonar.java.se.utils.CFGTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramPointTest {
  @Test
  void test_to_string_method() {
    // ToString method of program point is used by viewer.
    CFG cfg = CFGTestUtils.buildCFG("void foo() {foo();}");
    ProgramPoint pp = new ProgramPoint(cfg.blocks().get(0));
    assertThat(pp).hasToString("B1.0  IDENTIFIER1");
    pp = pp.next().next();
    assertThat(pp).hasToString("B1.2  ");
  }

}
