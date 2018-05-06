package xmlpulldemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import data_struct.DataFileXmlItem;
import view.Basewin;
import view.Mainwin;

public class LayoutInflate {
	
	boolean DEBUG = true;
	long start = 0;
	private final Object[] mConstructorArgs = new Object[1];
    private static final String TAG_MERGE = "merge";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_REQUEST_FOCUS = "requestFocus";

	private static final String TAG = "Engine";
    private static final HashMap<String, Constructor> sConstructorMap =
            new HashMap<String, Constructor>();

    private static final Class[] mConstructorSignature = new Class[] {
    		 AttributeSet.class};
    private DataFileXmlItem dataFileXmlItem;
    
    public LayoutInflate(DataFileXmlItem dataFileXmlItem) {
    	this.dataFileXmlItem = dataFileXmlItem;
    }
    
    public Basewin inflate(String resource, Basewin root){
        return inflate(resource, root, root != null);
    }
    
    public Basewin inflate(String resource, Basewin root, boolean attachToRoot){
        start = System.currentTimeMillis();
    	System.out.println("INFLATING from resource: " + resource);
           
		try {
			// 创建一个解析工厂
	        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	        // 由工厂创建一个解析器对象
	        XmlPullParser parser;
			parser = factory.newPullParser();
			parser.setInput(new FileInputStream(resource), "UTF-8");
			return inflate(parser, root, attachToRoot);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
    }
    
    public Basewin inflate(XmlPullParser parser, Basewin root, boolean attachToRoot) throws Exception {
            Basewin result = root;
            AttributeSet attrs = new AttributeSet(parser);
            try {
                // Look for the root node.
                int type;
                while ((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT) {
                    // Empty
                }

                if (type != XmlPullParser.START_TAG) {
                    throw new Exception(parser.getPositionDescription()
                            + ": No start tag found!");
                }

                final String name = parser.getName();
                
                if (DEBUG) {
                    System.out.println("**************************");
                    System.out.println("Creating root view: " + name);
                    System.out.println("**************************");
                }

                if (TAG_MERGE.equals(name)) {
                    if (root == null || !attachToRoot) {
                        throw new Exception("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                    }

                    rInflate(parser, root, attrs);
                } else {
                    // Temp is the root view that was found in the xml
                    Basewin temp = createViewFromTag(name, attrs);
                    Params params = null;

                    if (root != null) {
                        if (DEBUG) {
                            System.out.println("Creating params from root: " + root);
                        }
                        // Create layout params that match root, if supplied
                        params = root.generateLayoutParams(attrs);
                        if (!attachToRoot) {
                            // Set the layout params for temp if we are not
                            // attaching. (If we are, we use addView, below)
                            temp.setLayoutParams(params);
                        }
                    }

                    if (DEBUG) {
                        System.out.println("-----> start inflating children");
                    }
                    // Inflate all children under temp
                    rInflate(parser, temp, attrs);
                    if (DEBUG) {
                        System.out.println("-----> done inflating children");
                    }

                    // We are supposed to attach all the views we found (int temp)
                    // to root. Do that now.
                    if (root != null && attachToRoot) {
                        root.addView(temp, params);
                    }

                    // Decide whether to return the root that was passed in or the
                    // top view found in xml.
                    if (root == null || !attachToRoot) {
                        result = temp;
                    }
                }

            } catch (XmlPullParserException e) {
            	e.printStackTrace();
            } catch (IOException e) {
               e.printStackTrace();
            }
            System.out.println("inflate time: "+(System.currentTimeMillis()-start));
            return result;
        }
    
    public Basewin createViewFromTag(String name, AttributeSet attrs) {
        if (name.equals("Basewin")) {
            name = attrs.getAttributeValue(null, "class");
        }

        if (DEBUG) 
        	System.out.println("******** Creating view: " + name);

        try {
        	Basewin view = null;
            if (view == null) {
                if (-1 == name.indexOf('.')) {
                	//android鑷甫鐨刅iew
                    //view = onCreateView(name, attrs);
                	view = createView(name, "view.", attrs);
                } else {
                	//鑷畾涔夌殑View
                    view = createView(name, "view.", attrs);
                }
            }
           
            if (DEBUG) 
            	System.out.println("Created view is: " + view);
            
            dataFileXmlItem.addViewTableItem(view.getViewTableItem());
            return view;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public final Basewin createView(String name, String prefix, AttributeSet attrs)
            throws ClassNotFoundException {
    	//浠庢瀯閫犲櫒缂撳啿姹犱腑鑾峰彇鏋勯?犲櫒
        Constructor constructor = sConstructorMap.get(name);
        Class clazz = null;
       
        try {
            if (constructor == null) {
                // Class not found in the cache, see if it's real, and try to add it
            	//Log.e(TAG,prefix != null ? (prefix + name) : name);
            	//瑁呰浇绫?
                clazz = this.getClass().getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);
               // clazz=Class.forName(prefix != null ? (prefix + name) : name);
                /*
                if (mFilter != null && clazz != null) {
                    boolean allowed = mFilter.onLoadClass(clazz);
                    if (!allowed) {
                        failNotAllowed(name, prefix, attrs);
                    }
                }
                */
                //鑾峰彇鍒版瀯閫犲櫒
                constructor = clazz.getConstructor(mConstructorSignature);
                //灏嗘瀯閫犲櫒鏀惧叆缂撳啿姹犲綋涓?
                sConstructorMap.put(name, constructor);
                //濡傛灉allowedState涓簍rue,鍒欏凡缁忚杞借繃锛屾棤闇?鍐嶈杞斤紝鍙渶鑾峰緱瀹炰緥渚垮彲銆?
            }
            Object[] args = mConstructorArgs;
            args[0] = attrs;
            //鑾峰彇鍒癡iew鐨勫疄渚?
            return (Basewin) constructor.newInstance(args);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void rInflate(XmlPullParser parser, Basewin parent, final AttributeSet attrs)throws Exception {

        final int depth = parser.getDepth();
        int type;

        while (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT) {

            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            final String name = parser.getName();
            
            if (TAG_REQUEST_FOCUS.equals(name)) {
                //parseRequestFocus(parser, parent);
            } else if (TAG_INCLUDE.equals(name)) {
                if (parser.getDepth() == 0) {
                    throw new Exception("<include /> cannot be the root element");
                }
                parseInclude(parser, parent, attrs);
            } else if (TAG_MERGE.equals(name)) {
                throw new Exception("<merge /> must be the root element");
            } else {
                final Basewin view = createViewFromTag(name, attrs);
                final Basewin viewGroup = (Basewin) parent;
                String name1=viewGroup.getClass().getName();
              //final Params createparams=ResourceUtil.createParams(viewGroup.getContext(), name1);
             // final LinearLayoutParams createparams=new LinearLayoutParams(parent.getContext());
              //final ViewGroup.LayoutParams params = createparams.generateLayoutParams(attrs);
              Params params = null;
              rInflate(parser, view, attrs);
              viewGroup.addView(view, params);
              //Log.i(TAG, params.width+"&&&"+params.height);
               
            }
        }
//        parent.onFinishInflate();
    }
    
    private void parseInclude(XmlPullParser parser, Basewin parent, AttributeSet attrs)
            throws Exception {
    	
        int type;
       
        if (parent instanceof Basewin) {
        	
            final int layout = attrs.getAttributeResourceValue(null, "layout", 0);
            if (layout == 0) {
                final String value = attrs.getAttributeValue(null, "layout");
                if (value == null) {
                    throw new Exception("You must specifiy a layout in the"
                            + " include tag: <include layout=\"@layout/layoutID\" />");
                } else {
                    throw new Exception("You must specifiy a valid layout "
                            + "reference. The layout ID " + value + " is not valid.");
                }
            } else {
                //final XmlResourceParser childParser =
                 //       getContext().getResources().getLayout(layout);
            	 final String value = attrs.getAttributeValue(null, "layout");
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                // 由工厂创建一个解析器对象
                XmlPullParser childParser = factory.newPullParser();
                parser.setInput(new FileInputStream(value), "UTF-8");
                try {
                    final AttributeSet childAttrs = new AttributeSet(childParser);

                    while ((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT) {
                        // Empty.
                    }

                    if (type != XmlPullParser.START_TAG) {
                        throw new Exception(childParser.getPositionDescription() +
                                ": No start tag found!");
                    }

                    final String childName = childParser.getName();

                    if (TAG_MERGE.equals(childName)) {
                        // Inflate all children.
                        rInflate(childParser, parent, childAttrs);
                    } else {
                        final Basewin view = createViewFromTag(childName, childAttrs);
                        final Basewin group = (Basewin) parent;

                        // We try to load the layout params set in the <include /> tag. If
                        // they don't exist, we will rely on the layout params set in the
                        // included XML file.
                        // During a layoutparams generation, a runtime exception is thrown
                        // if either layout_width or layout_height is missing. We catch
                        // this exception and set localParams accordingly: true means we
                        // successfully loaded layout params from the <include /> tag,
                        // false means we need to rely on the included layout params.
                        Params params = null;
                        try {
                            params = group.generateLayoutParams(attrs);
                        } catch (RuntimeException e) {
                            params = group.generateLayoutParams(childAttrs);
                        } finally {
                            if (params != null) {
                                view.setLayoutParams(params);
                            }
                        }

                        // Inflate all children.
                        rInflate(childParser, view, childAttrs);

                        // Attempt to override the included layout's android:id with the
                        // one set on the <include /> tag itself.
                       /* TypedArray a = mContext.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.View, 0, 0);
                        int id = a.getResourceId(com.android.internal.R.styleable.View_id, View.NO_ID);
                        // While we're at it, let's try to override android:visibility.
                        int visibility = a.getInt(com.android.internal.R.styleable.View_visibility, -1);
                        a.recycle();

                        if (id != View.NO_ID) {
                            view.setId(id);
                        }

                        switch (visibility) {
                            case 0:
                                view.setVisibility(View.VISIBLE);
                                break;
                            case 1:
                                view.setVisibility(View.INVISIBLE);
                                break;
                            case 2:
                                view.setVisibility(View.GONE);
                                break;
                        }*/

                        group.addView(view,null);
                    }
                } finally {
                    //childParser.close();
                    
                }
            }
        } else {
            throw new Exception("<include /> can only be used inside of a ViewGroup");
        }

        final int currentDepth = parser.getDepth();
        while (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT) {
            // Empty
        }
    }    

}
