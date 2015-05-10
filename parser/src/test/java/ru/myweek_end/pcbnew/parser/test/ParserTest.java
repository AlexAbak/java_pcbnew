/*
 * Copyright © 2015 "Алексей Кляузер <drum@pisem.net>" Все права защищены.
 */

/*
 * This file is part of java_pcbnew.
 * 
 * java_pcbnew is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * java_pcbnew is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with java_pcbnew.  If not, see <http://www.gnu.org/licenses/>.
 */

/* 
 * Этот файл — часть java_pcbnew.
 * 
 * java_pcbnew - свободная программа: вы можете перераспространять ее и/или
 * изменять ее на условиях Афферо Стандартной общественной лицензии GNU в
 * том виде, в каком она была опубликована Фондом свободного программного
 * обеспечения; либо версии 3 лицензии, либо (по вашему выбору) любой более
 * поздней версии.
 * 
 * java_pcbnew распространяется в надежде, что она будет полезной, но БЕЗО
 * ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА или ПРИГОДНОСТИ
 * ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Афферо Стандартной общественной
 * лицензии GNU.
 * 
 * Вы должны были получить копию Афферо Стандартной общественной лицензии GNU
 * вместе с этой программой. Если это не так, см.
 * <http://www.gnu.org/licenses/>.
 */

package ru.myweek_end.pcbnew.parser.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import ru.myweek_end.pcbnew.parser.Parser;
import ru.myweek_end.pcbnew.parser.PcbnewObject;


/**
 * Тест парсера.
 * @author <a href="https://myweek-end.ru/">Моя неделя завершилась</a>
 * @author <a href="mailto:drum@pisem.net">Алексей Кляузер</a>
 * @since 0.0.1.3
 * @version 0.0.1.3
 */
public class ParserTest {

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse0() throws IOException {
		Reader reader = new StringReader("test");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals("test", object.getName());
		assertEquals(0, object.getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse1() throws IOException {
		Reader reader = new StringReader("(test)");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals(null, object.getName());
		assertEquals(1, object.getChilds().size());
		assertEquals("test", object.getChilds().get(0).getName());
		assertEquals(0, object.getChilds().get(0).getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse2() throws IOException {
		Reader reader = new StringReader("(test test0)");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals(null, object.getName());
		assertEquals(1, object.getChilds().size());
		assertEquals("test", object.getChilds().get(0).getName());
		assertEquals(1, object.getChilds().get(0).getChilds().size());
		assertEquals("test0", object.getChilds().get(0).getChilds().get(0).getName());
		assertEquals(0, object.getChilds().get(0).getChilds().get(0).getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse3() throws IOException {
		Reader reader = new StringReader("test test0 test1");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals("test", object.getName());
		assertEquals(2, object.getChilds().size());
		assertEquals("test0", object.getChilds().get(0).getName());
		assertEquals(0, object.getChilds().get(0).getChilds().size());
		assertEquals("test1", object.getChilds().get(1).getName());
		assertEquals(0, object.getChilds().get(1).getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse4() throws IOException {
		Reader reader = new StringReader("\"t est\\t\\ \\n \\r\"");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals("t estt \n \r", object.getName());
		assertEquals(0, object.getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse5() throws IOException {
		Reader reader = new StringReader("test (test0 \"value0\")(test1 \"value 1\")");
		Parser parser = new Parser();
		PcbnewObject object = parser.parse(reader);
		assertNotNull(object);
		assertEquals("test", object.getName());
		assertEquals(2, object.getChilds().size());
		assertEquals("test0", object.getChilds().get(0).getName());
		assertEquals(1, object.getChilds().get(0).getChilds().size());
		assertEquals("value0", object.getChilds().get(0).getChilds().get(0).getName());
		assertEquals(0, object.getChilds().get(0).getChilds().get(0).getChilds().size());
		assertEquals("test1", object.getChilds().get(1).getName());
		assertEquals(1, object.getChilds().get(1).getChilds().size());
		assertEquals("value 1", object.getChilds().get(1).getChilds().get(0).getName());
		assertEquals(0, object.getChilds().get(1).getChilds().get(0).getChilds().size());
	}

	/**
	 * Test method for {@link ru.myweek_end.pcbnew.parser.Parser#parse(java.io.Reader)}.
	 * @throws IOException 
	 * @since 0.0.1.3
	 */
	@Test
	public void testParse6() {
		Reader reader = new IOExceptionReader();
		Parser parser = new Parser();
		try {
			parser.parse(reader);
		} catch (IOException e) {
			assertEquals(IOException.class, e.getClass());
		}
	}

}
