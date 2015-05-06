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
 * Объект Pcbnew.
 * @author <a href="https://myweek-end.ru/">Моя неделя завершилась</a>
 * @author <a href="mailto:drum@pisem.net">Алексей Кляузер</a>
 * @since 0.0.1.2
 * @version 0.0.1.2
 */
public class PcbnewObject {

	/**
	 * Родительский объект
	 * @since 0.0.1.2
	 */
	private PcbnewObject parent;

	/**
	 * Имя объекта
	 * @since 0.0.1.2
	 */
	private String name;

	/**
	 * Список детей
	 * @since 0.0.1.2
	 */
	private PcbnewObjectList childs = new PcbnewObjectList();

	/**
	 * Получить родительский объект
	 * @since 0.0.1.2
	 * @return Родительский объект
	 */
	public PcbnewObject getParent () {
		return this.parent;
	}

	/**
	 * Получить имя объекта
	 * @since 0.0.1.2
	 * @return Имя объекта
	 */
	public String getName () {
		return this.name;
	}

	/**
	 * Установить имя объекта
	 * @since 0.0.1.2
	 * @param name Имя объекта
	 */
	public void setName (String name) {
		this.name = name;
	}

	/**
	 * Получить список детей
	 * @since 0.0.1.2
	 * @return Список детей
	 */
	public PcbnewObjectList getChilds () {
		return this.childs;
	}

	/**
	 * Конструктор
	 * @since 0.0.1.2
	 * @param parent Родительский объект
	 */
	public PcbnewObject (PcbnewObject parent) {
		this.parent = parent;
		if (parent != null) {
			parent.getChilds().add(this);
		}
	}

	/**
	 * Добавить строку
	 * @since 0.0.1.2
	 * @param source Строка
	 */
	public void appendString (String source) {
		if (this.name == null) {
			this.name = source;
		} else {
			PcbnewObject child = new PcbnewObject(this);
			child.setName(source);
		}
	}

}
