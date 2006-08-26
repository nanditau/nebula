package org.eclipse.swt.nebula.snippets.ctabletree;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.ctabletree.CTableTreeCell;
import org.eclipse.swt.nebula.widgets.ctabletree.ccontainer.CContainerItem;
import org.eclipse.swt.nebula.widgets.ctabletree.ccontainer.SComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * A Sample custom cell of style DROP_DOWN.  Uses the CContainerCell's toggle
 * via style TOGGLE, and contains a native SWT Table.
 */
public class TableCell extends CTableTreeCell {

	private Table table;
	
	public TableCell(CContainerItem item, int style) {
		super(item, style | SWT.DROP_DOWN | SWT.TOGGLE);
	}

	protected void createChildContents(SComposite contents, int style) {
		contents.setBorderStyle(SWT.BORDER);
		contents.setBorderWidth(1);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		contents.setLayout(layout);

		table = new Table(contents, SWT.VERTICAL);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableColumn col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 1");
		col.pack();
		col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 2");
		col.pack();
		col = new TableColumn(table, SWT.CENTER);
		col.setText("Column 3");
		col.pack();

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i1, c1", "i1, c2", "i1, c3" } );
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i2, c1", "i2, c2", "i2, c3" } );
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "i3, c1", "i3, c2", "i3, c3" } );
	}
	
	protected List getColorManagedControls() {
		List list = super.getColorManagedControls();
		list.remove(table);
		return list;
	}
	
	protected List getEventManagedControls() {
		List list = super.getEventManagedControls();
		list.remove(table);
		return list;
	}
}
