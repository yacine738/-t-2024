import os
import tkinter as tk
from tkinter import filedialog, simpledialog, colorchooser, ttk
from tkinter import font as tkfont

# Create the main window
root = tk.Tk()
root.title("Untitled* - Script Editor")

# Variables
filename = ""
fontColor = "black"
tBackground = "white"
current_font_family = "Arial"
current_font_size = 12

# Function to create a new file
def new(event=None):
    global filename
    filename = ""
    text.delete(1.0, tk.END)
    root.title("Untitled* - Script Editor")

# Function to open a file
def open_file(event=None):
    global filename
    filename = filedialog.askopenfilename(defaultextension=".txt")
    if filename:
        text.delete(1.0, tk.END)
        with open(filename, "r") as f:
            text.insert(tk.END, f.read())
        root.title(os.path.basename(filename) + " - Script Editor")

# Function to save the file
def save(event=None):
    global filename
    if filename:
        with open(filename, "w") as f:
            f.write(text.get(1.0, tk.END))
    else:
        save_as()

# Function to save the file with a new name
def save_as():
    global filename
    filename = filedialog.asksaveasfilename(defaultextension=".txt")
    if filename:
        with open(filename, "w") as f:
            f.write(text.get(1.0, tk.END))
        root.title(os.path.basename(filename) + " - Script Editor")

# Function to rename the file
def rename(event=None):
    global filename
    if filename == "":
        open_file()
    arr = filename.split("/")
    path = ""
    for i in range(0, len(arr) - 1):
        path = path + arr[i] + "/"
    new_name = simpledialog.askstring("Rename", "Enter new name")
    if new_name:
        os.rename(filename, str(path) + str(new_name))
        filename = str(path) + str(new_name)
        root.title(os.path.basename(filename) + " - Script Editor")

# Function to close the application
def close(event=None):
    save()
    root.quit()

# EDIT MENU METHODS
def cut(event=None):
    root.clipboard_clear()
    root.clipboard_append(string=text.selection_get())
    text.delete("sel.first", "sel.last")

def copy(event=None):
    root.clipboard_clear()
    root.clipboard_append(string=text.selection_get())

def paste(event=None):
    text.insert("insert", root.clipboard_get())

def delete():
    text.delete("sel.first", "sel.last")

def select_all(event=None):
    text.tag_add("sel", "1.0", "end")

def delete_all():
    text.delete(1.0, "end")

# TOOLS MENU METHODS
def change_color():
    color = colorchooser.askcolor(initialcolor='#ff0000')
    if color[1] is None:
        return

    global fontColor
    fontColor = color[1]

    current_tags = text.tag_names("sel.first")
    if "font_color_change" in current_tags:
        text.tag_delete("font_color_change", "sel.first", "sel.last")
    else:
        text.tag_add("font_color_change", "sel.first", "sel.last")
        make_tag()

def check(value):
    text.tag_remove('found', '1.0', "end")
    text.tag_config('found', foreground='red')

    list_of_words = value.split(' ')
    for word in list_of_words:
        idx = '1.0'
        while True:
            idx = text.search(word, idx, nocase=1, stopindex="end")
            if not idx:
                break

            lastidx = f"{idx}+{len(word)}c"
            text.tag_add('found', idx, lastidx)
            idx = lastidx

def find_text(event=None):
    search_toplevel = tk.Toplevel(root)
    search_toplevel.title('Find Text')
    search_toplevel.transient(root)
    search_toplevel.resizable(False, False)
    ttk.Label(search_toplevel, text="Find All:").grid(row=0, column=0, sticky='e')
    search_entry_widget = ttk.Entry(search_toplevel, width=25)
    search_entry_widget.grid(row=0, column=1, padx=2, pady=2, sticky='we')
    search_entry_widget.focus_set()
    ttk.Button(search_toplevel, text="Ok", command=lambda: check(search_entry_widget.get())).grid(row=0, column=2, padx=2, pady=2)
    ttk.Button(search_toplevel, text="Cancel", command=search_toplevel.destroy).grid(row=0, column=3, padx=2, pady=2)

# FORMAT BAR METHODS
def bold(event=None):
    current_tags = text.tag_names("sel.first")
    if text.tag_ranges("sel"):  # Check if there is a selection
        if "bold" in current_tags:
            text.tag_remove("bold", "sel.first", "sel.last")
        else:
            text.tag_add("bold", "sel.first", "sel.last")
            make_tag()

def italic(event=None):
    current_tags = text.tag_names("sel.first")
    if text.tag_ranges("sel"):  # Check if there is a selection
        if "italic" in current_tags:
            text.tag_remove("italic", "sel.first", "sel.last")
        else:
            text.tag_add("italic", "sel.first", "sel.last")
            make_tag()

def underline(event=None):
    current_tags = text.tag_names("sel.first")
    if text.tag_ranges("sel"):  # Check if there is a selection
        if "underline" in current_tags:
            text.tag_remove("underline", "sel.first", "sel.last")
        else:
            text.tag_add("underline", "sel.first", "sel.last")
            make_tag()

def strike(event=None):
    current_tags = text.tag_names("sel.first")
    if text.tag_ranges("sel"):  # Check if there is a selection
        if "overstrike" in current_tags:
            text.tag_remove("overstrike", "sel.first", "sel.last")
        else:
            text.tag_add("overstrike", "sel.first", "sel.last")
            make_tag()

def highlight(event=None):
    color = colorchooser.askcolor(initialcolor='white')
    color_rgb = color[1]
    global tBackground
    tBackground = color_rgb

    current_tags = text.tag_names("sel.first")
    if text.tag_ranges("sel"):  # Check if there is a selection
        if "background_color_change" in current_tags:
            text.tag_remove("background_color_change", "sel.first", "sel.last")
        else:
            text.tag_add("background_color_change", "sel.first", "sel.last")
            make_tag()

def make_tag():
    current_tags = text.tag_names("sel.first")
    text.tag_configure("font", font=(current_font_family, current_font_size), foreground=fontColor, background=tBackground)
    if "bold" in current_tags:
        text.tag_add("bold", "sel.first", "sel.last")
        text.tag_configure("bold", font=(current_font_family, current_font_size, 'bold'), foreground=fontColor, background=tBackground)
    if "italic" in current_tags:
        text.tag_add("italic", "sel.first", "sel.last")
        text.tag_configure("italic", font=(current_font_family, current_font_size, 'italic'), foreground=fontColor, background=tBackground)
    if "underline" in current_tags:
        text.tag_add("underline", "sel.first", "sel.last")
        text.tag_configure("underline", font=(current_font_family, current_font_size), underline=True, foreground=fontColor, background=tBackground)
    if "overstrike" in current_tags:
        text.tag_add("overstrike", "sel.first", "sel.last")
        text.tag_configure("overstrike", font=(current_font_family, current_font_size), overstrike=True, foreground=fontColor, background=tBackground)
    if "background_color_change" in current_tags:
        text.tag_add("background_color_change", "sel.first", "sel.last")
        text.tag_configure("background_color_change", font=(current_font_family, current_font_size), background=tBackground)

# Alignment methods
def align_left(event=None):
    text.tag_configure('left', justify='left')
    text.tag_add('left', 'sel.first', 'sel.last')

def align_center(event=None):
    text.tag_configure('center', justify='center')
    text.tag_add('center', 'sel.first', 'sel.last')

def align_right(event=None):
    text.tag_configure('right', justify='right')
    text.tag_add('right', 'sel.first', 'sel.last')

# MAIN MENU
menubar = tk.Menu(root)

file_menu = tk.Menu(menubar)
file_menu.add_command(label="New", command=new, accelerator="Ctrl+N")
file_menu.add_command(label="Open", command=open_file, accelerator="Ctrl+O")
file_menu.add_command(label="Save", command=save, accelerator="Ctrl+S")
file_menu.add_command(label="Save As", command=save_as)
file_menu.add_command(label="Rename", command=rename)
file_menu.add_separator()
file_menu.add_command(label="Exit", command=close, accelerator="Ctrl+Q")
menubar.add_cascade(label="File", menu=file_menu)

edit_menu = tk.Menu(menubar)
edit_menu.add_command(label="Cut", command=cut, accelerator="Ctrl+X")
edit_menu.add_command(label="Copy", command=copy, accelerator="Ctrl+C")
edit_menu.add_command(label="Paste", command=paste, accelerator="Ctrl+V")
edit_menu.add_command(label="Delete", command=delete)
edit_menu.add_separator()
edit_menu.add_command(label="Select All", command=select_all, accelerator="Ctrl+A")
edit_menu.add_command(label="Delete All", command=delete_all)
menubar.add_cascade(label="Edit", menu=edit_menu)

tools_menu = tk.Menu(menubar)
tools_menu.add_command(label="Find Text", command=find_text, accelerator="Ctrl+F")
tools_menu.add_command(label="Change Font Color", command=change_color)
tools_menu.add_separator()
menubar.add_cascade(label="Tools", menu=tools_menu)

root.config(menu=menubar)

# Toolbar
toolbar = ttk.Frame(root)
toolbar.pack(side=tk.TOP, fill=tk.X)

# Add buttons to the toolbar
ttk.Button(toolbar, text="Bold", command=bold).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Italic", command=italic).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Underline", command=underline).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Strikethrough", command=strike).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Highlight", command=highlight).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Align Left", command=align_left).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Align Center", command=align_center).pack(side=tk.LEFT, padx=2, pady=2)
ttk.Button(toolbar, text="Align Right", command=align_right).pack(side=tk.LEFT, padx=2, pady=2)

# Add font family dropdown
font_families = sorted(tkfont.families())  # Use tkfont to access font families
font_family_var = tk.StringVar(value=current_font_family)
font_family_dropdown = ttk.Combobox(toolbar, textvariable=font_family_var, values=font_families, state='readonly')
font_family_dropdown.pack(side=tk.LEFT, padx=2, pady=2)
font_family_dropdown.bind("<<ComboboxSelected>>", lambda event: change_font_family())

# Add font size dropdown
font_sizes = list(range(8, 33, 2))
font_size_var = tk.IntVar(value=current_font_size)
font_size_dropdown = ttk.Combobox(toolbar, textvariable=font_size_var, values=font_sizes, state='readonly')
font_size_dropdown.pack(side=tk.LEFT, padx=2, pady=2)
font_size_dropdown.bind("<<ComboboxSelected>>", lambda event: change_font_size())

# Text widget
text = tk.Text(root, wrap='word', undo=True)
text.pack(expand='yes', fill='both')
text.config(font=(current_font_family, current_font_size))

# Keyboard shortcuts
root.bind_all("<Control-n>", new)
root.bind_all("<Control-o>", open_file)
root.bind_all("<Control-s>", save)
root.bind_all("<Control-q>", close)
root.bind_all("<Control-x>", cut)
root.bind_all("<Control-c>", copy)
root.bind_all("<Control-v>", paste)
root.bind_all("<Control-a>", select_all)
root.bind_all("<Control-f>", find_text)

def change_font_family():
    global current_font_family
    current_font_family = font_family_var.get()
    text.config(font=(current_font_family, current_font_size))
    make_tag()

def change_font_size():
    global current_font_size
    current_font_size = font_size_var.get()
    text.config(font=(current_font_family, current_font_size))
    make_tag()

root.mainloop()
