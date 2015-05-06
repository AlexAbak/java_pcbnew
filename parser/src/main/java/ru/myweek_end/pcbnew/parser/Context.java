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
 * Контекст.
 * @author <a href="https://myweek-end.ru/">Моя неделя завершилась</a>
 * @author <a href="mailto:drum@pisem.net">Алексей Кляузер</a>
 * @since 0.0.1.2
 * @version 0.0.1.2
 */
public class Context {

	/**
	 * Текущее состояние разбора
	 * @since 0.0.1.2
	 */
	private State state;

	/**
	 * Текущий объект
	 * @since 0.0.1.2
	 */
	private PcbnewObject current;

	/**
	 * Накопитель текущей строки
	 * @since 0.0.1.2
	 */
	private StringBuilder buffer = new StringBuilder();

	/**
	 * Получить текущее состояние разбора
	 * @since 0.0.1.2
	 * @return Текущее состояние разбора
	 */
	public State getState () {
		return this.state;
	}

	/**
	 * Установить текущее состояние разбора
	 * @since 0.0.1.2
	 * @param state Текущее состояние разбора
	 */
	public void setState (State state) {
		this.state = state;
	}

	/**
	 * Получить текущий объект
	 * @since 0.0.1.2
	 * @return Текущий объект
	 */
	public PcbnewObject getCurrentObject () {
		return this.current;
	}

	/**
	 * Установить текущий объект
	 * @since 0.0.1.2
	 * @param current Текущий объект
	 */
	public void setCurrentObject (PcbnewObject current) {
		this.current = current;
	}

	/**
	 * Получить накопитель текущей строки
	 * @since 0.0.1.2
	 * @return Накопитель текущей строки
	 */
	public StringBuilder getBuffer () {
		return this.buffer;
	}

}
