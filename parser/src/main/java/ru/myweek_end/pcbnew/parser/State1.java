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

package ru.myweek_end.pcbnew.parser;

/**
 * Состояние 1.
 * @author <a href="https://myweek-end.ru/">Моя неделя завершилась</a>
 * @author <a href="mailto:drum@pisem.net">Алексей Кляузер</a>
 * @since 0.0.1.2
 * @version 0.0.1.2
 */
public class State1 implements State {

	/* (non-Javadoc)
	 * @see ru.myweek_end.pcbnew.parser.State#step(java.lang.Character, ru.myweek_end.pcbnew.parser.Context)
	 * @since 0.0.1.2
	 */
	@Override
	public Context step(Character character, Context context) {
		switch (character) {

			case '\\':
				context.setState(new State3());
			break;

			case '"':
				context.setState(new State0());
				context.getCurrentObject().appendString(context.getBuffer().toString());
				context.getBuffer().setLength(0);
			break;

			default:
				context.getBuffer().append(character);
			break;

		}
		return context;
	}

}
